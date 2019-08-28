package com.pichler.examples.avro

import java.util.*
import kotlin.collections.ArrayList

class Queue {
    companion object {
        private val queue = ArrayList<String>()

        @Synchronized
        fun add(message: String) {
            queue.add(message)
        }

        @Synchronized
        fun readFirst(): Optional<String> {
            if (queue.isEmpty()) {
                return Optional.empty();
            }
            val message = queue.get(0)
            queue.removeAt(0)
            return Optional.ofNullable(message)
        }
    }
}