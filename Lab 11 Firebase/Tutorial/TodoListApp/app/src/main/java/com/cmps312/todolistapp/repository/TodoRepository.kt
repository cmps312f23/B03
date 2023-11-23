package com.cmps312.todolistapp.repository

import android.util.Log
import com.cmps312.todolistapp.model.Project
import com.cmps312.todolistapp.model.Todo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

//All the crud operations
class TodoRepository {
    val TAG = "TodoRepository"

    //get a link to the database
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    // get the collections
    private val projectCollectionRef = db.collection("project")
    private val todosCollectionRef = db.collection("todos")

    fun addProject(project: Project) = projectCollectionRef.add(project)
    fun updateProject(project: Project) = projectCollectionRef
        .document(project.id)
        .set(project)

    //    come back to this function
    suspend fun deleteProject(project: Project) {
//        delete all the todos
        val todos = getTodoListByProject(project.id)
        todos.forEach { deleteTodo(it) }

        //delete the project
        projectCollectionRef.document(project.id).delete()
    }

    fun observeProjects(): Flow<List<Project>> = callbackFlow {
        val snapShotListener = projectCollectionRef.addSnapshotListener { values, err ->
            if (err != null)
                return@addSnapshotListener
            //parse the values
            val projects = values!!.toObjects(Project::class.java)
            trySend(projects)
        }
        awaitClose { snapShotListener.remove() }
    }

    fun observeTodos(pid: String): Flow<List<Todo>> = callbackFlow {
        val snapShotListener = todosCollectionRef
            .whereEqualTo("pid", pid)
            .addSnapshotListener { values, err ->
                if (err != null)
                    return@addSnapshotListener
                //parse the values
                val todos = values!!.toObjects(Todo::class.java)
                trySend(todos)
            }
        awaitClose { snapShotListener.remove() }
    }

    suspend fun getTodo(id: String) =
        todosCollectionRef
            .document(id)
            .get()
            .await()
            .toObject(Todo::class.java)

    suspend fun addTodo(todo: Todo) = todosCollectionRef.add(todo).await().id

    fun updateTodo(todo: Todo) = todosCollectionRef
        .document(todo.id)
        .set(todo)
        .addOnSuccessListener { Log.d(TAG, "Successfully updated") }
        .addOnFailureListener { Log.d(TAG, "Unable to updated") }

    fun deleteTodo(todo: Todo) = todosCollectionRef.document(todo.id).delete()

    suspend fun getTodoListByProject(pid: String) = todosCollectionRef
        .whereEqualTo("pid", pid)
        .get().await().toObjects(Todo::class.java)
}