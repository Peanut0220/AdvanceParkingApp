package com.example.parkly.data

import com.google.firebase.firestore.Blob
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.Exclude

data class ParkingSpace(
    val spaceID: String="",
    var currentUserID: String="",
    var currentCarImage: Blob = Blob.fromBytes(ByteArray(0)),
    var spaceStatus: String = "Available",
    var currentRecordID: String = "",
    var updatedAt: Long =0
) {
    // No-argument constructor is created by default due to Kotlin's data class
}