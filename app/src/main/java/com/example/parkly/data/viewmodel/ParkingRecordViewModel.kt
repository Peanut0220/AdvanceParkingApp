package com.example.parkly.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.parkly.data.ParkingRecord
import com.example.parkly.data.ParkingSpace
import com.example.parkly.data.Vehicle
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.Firebase
import com.google.firebase.firestore.Blob
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObjects

class ParkingRecordViewModel(val app: Application) : AndroidViewModel(app){
    private val PARKINGRECORDS = Firebase.firestore.collection("parkingRecord")
    private val _parkingRecordLD = MutableLiveData<List<ParkingRecord>>()
    private var listener: ListenerRegistration? = null
    private val required = "* Required"

    init {
        listener = PARKINGRECORDS.addSnapshotListener { snap, _ ->
            _parkingRecordLD.value = snap?.toObjects()
        }
    }

    fun init() = Unit

    fun getParkingRecordLD() = _parkingRecordLD

    fun getAll() = _parkingRecordLD.value ?: emptyList()

    fun get(recordID: String) = getAll().find { it.recordID == recordID }

    fun getBySpace(spaceID: String) = getAll().find { it.spaceID == spaceID }

    fun set(record: ParkingRecord) {
        PARKINGRECORDS.document().set(record)
    }

    fun update(record: ParkingRecord) {
        PARKINGRECORDS.document(record.recordID).set(record)
    }





}