package com.photo.mahsa

import com.photo.mahsa.model.Task

object TestModel {

    val fakeTaskList = MutableList(15) { Task(it.toLong(), "title $it", "desk $it") }
}