package com.cmps312.todolistapp.repository

import android.util.Log
import com.cmps312.todolistapp.model.Project
import com.cmps312.todolistapp.model.Todo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class TodoRepository {

    private val db: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val projectDocumentsRef by lazy { db.collection("projects") }
    private val todoDocumentsRef by lazy { db.collection("todos") }

    fun observeProjects(): Flow<List<Project>> = callbackFlow {
        val snapshot = projectDocumentsRef
            .addSnapshotListener { value, e ->
                if (e != null)
                    return@addSnapshotListener
                val projects = value!!.toObjects(Project::class.java)
                if (projects != null)
                    this.trySend(projects)
            }
        awaitClose {
            snapshot.remove()
        }
    }

    fun addProject(project: Project) = projectDocumentsRef.add(project)
        .addOnSuccessListener { Log.d("TAG", "Successfully added project: ") }
        .addOnFailureListener { Log.d("TAG", "Failed to add project: ") }


    fun updateProject(project: Project) = projectDocumentsRef.document(project.id).set(project)

    suspend fun deleteProject(project: Project) {
        val todos = getTodoListByProject(project.id)
        todos.forEach { todo ->
            deleteTodo(todo).await()
        }
        projectDocumentsRef.document(project.id).delete().await()
    }

    fun observeTodos(pid: String): Flow<List<Todo>> = callbackFlow {
        val snapshot = todoDocumentsRef
            .whereEqualTo("pid", pid)
            .addSnapshotListener { value, e ->
                if (e != null) {
                    Log.d("observeTodos", e.stackTraceToString())
                    return@addSnapshotListener
                }
                val todos = value!!.toObjects(Todo::class.java)
                if (todos.isNotEmpty())
                    this.trySend(todos)
            }
        awaitClose {
            snapshot.remove()
        }
    }

    suspend fun getTodo(id: String): Todo =
        todoDocumentsRef
            .document(id)
            .get().await().toObject(Todo::class.java)!!

    suspend fun addTodo(todo: Todo) =
        todoDocumentsRef.add(todo)
            .addOnSuccessListener { Log.d("TAG", "Successfully added: ") }
            .addOnFailureListener { Log.d("TAG", "Failed: ") }

    fun updateTodo(todo: Todo) = todoDocumentsRef.document(todo.id).set(todo)
    fun deleteTodo(todo: Todo) = todoDocumentsRef.document(todo.id).delete()

    suspend fun getTodoListByProject(pid: String): List<Todo> = todoDocumentsRef
        .whereEqualTo("pid", pid)
        .get()
        .await()
        .toObjects(Todo::class.java)
}