//package com.example.lab_exam_3
//
//import android.annotation.SuppressLint
//import android.content.ContentValues
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//
//class GymDatabase(context: Context) :
//    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
//
//    companion object {
//        private const val DATABASE_NAME = "gymDatabase.db"
//        private const val DATABASE_VERSION = 1
//        private const val TABLE_GYMS = "gyms"
//        private const val TABLE_USERS = "users"
//        private const val COLUMN_ID = "id"
//        private const val COLUMN_NAME = "name"
//        private const val COLUMN_LOCATION = "location"
//        private const val COLUMN_FEE = "fee"
//        private const val COLUMN_OPENING_HOURS = "opening_hours"
//        private const val COLUMN_USERNAME = "username"
//        private const val COLUMN_PASSWORD = "password"
//    }
//
//    override fun onCreate(db: SQLiteDatabase?) {
//        db?.execSQL(
//            "CREATE TABLE $TABLE_GYMS(" +
//                    "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    "$COLUMN_NAME TEXT," +
//                    "$COLUMN_LOCATION TEXT," +
//                    "$COLUMN_FEE REAL," +
//                    "$COLUMN_OPENING_HOURS TEXT)"
//        )
//        db?.execSQL(
//            "CREATE TABLE $TABLE_USERS(" +
//                    "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    "$COLUMN_USERNAME TEXT UNIQUE," +
//                    "$COLUMN_PASSWORD TEXT)"
//        )
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        db?.execSQL("DROP TABLE IF EXISTS $TABLE_GYMS")
//        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
//        onCreate(db)
//    }
//
//    fun insertGym(name: String, location: String, fee: Double, openingHours: String): Long {
//        val values = ContentValues().apply {
//            put(COLUMN_NAME, name)
//            put(COLUMN_LOCATION, location)
//            put(COLUMN_FEE, fee)
//            put(COLUMN_OPENING_HOURS, openingHours)
//        }
//        val db = writableDatabase
//        val id = db.insert(TABLE_GYMS, null, values)
//        db.close() // Close the database connection
//        return id
//    }
//
//    fun insertUser(username: String, password: String): Long {
//        val values = ContentValues().apply {
//            put(COLUMN_USERNAME, username)
//            put(COLUMN_PASSWORD, password)
//        }
//        val db = writableDatabase
//        val id = db.insert(TABLE_USERS, null, values)
//        db.close() // Close the database connection
//        return id
//    }
//
//    fun loginUser(username: String, password: String): Boolean {
//        val db = this.readableDatabase
//        val selection = "$COLUMN_USERNAME = ? AND $COLUMN_PASSWORD = ?"
//        val selectionArgs = arrayOf(username, password)
//        val cursor = db.query(
//            TABLE_USERS,
//            null,
//            selection,
//            selectionArgs,
//            null,
//            null,
//            null
//        )
//        val count = cursor.count
//        cursor.close()
//        db.close() // Close the database connection
//        return count > 0
//    }
//
//
//}

// GymDatabase.kt

package com.example.lab_exam_3

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class GymDatabase(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "gymDatabase.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_GYMS = "gyms"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_LOCATION = "location"
        private const val COLUMN_FEE = "fee"
        private const val COLUMN_OPENING_HOURS = "opening_hours"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE $TABLE_GYMS(" +
                    "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$COLUMN_NAME TEXT," +
                    "$COLUMN_LOCATION TEXT," +
                    "$COLUMN_FEE REAL," +
                    "$COLUMN_OPENING_HOURS TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_GYMS")
        onCreate(db)
    }

    fun insertGym(name: String, location: String, fee: Double, openingHours: String): Long {
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_LOCATION, location)
            put(COLUMN_FEE, fee)
            put(COLUMN_OPENING_HOURS, openingHours)
        }
        val db = writableDatabase
        val id = db.insert(TABLE_GYMS, null, values)
        db.close() // Close the database connection
        return id
    }

    data class Gym(
        val name: String,
        val location: String,
        val fee: Double,
        val openingHours: String
    ) {
        val id: Any
            get() {
                TODO()
            }
    }

    fun getAllGyms(): List<Gym> {
        val gymsList = mutableListOf<Gym>()
        val db = readableDatabase
        val cursor = db.query(
            TABLE_GYMS,
            null,
            null,
            null,
            null,
            null,
            null
        )
        cursor.use { // Use the cursor as a resource
            while (it.moveToNext()) {
                val nameIndex = it.getColumnIndex(COLUMN_NAME)
                val locationIndex = it.getColumnIndex(COLUMN_LOCATION)
                val feeIndex = it.getColumnIndex(COLUMN_FEE)
                val openingHoursIndex = it.getColumnIndex(COLUMN_OPENING_HOURS)

                if (nameIndex != -1 && locationIndex != -1 && feeIndex != -1 && openingHoursIndex != -1) {
                    val name = it.getString(nameIndex)
                    val location = it.getString(locationIndex)
                    val fee = it.getDouble(feeIndex)
                    val openingHours = it.getString(openingHoursIndex)
                    val gym = Gym(name, location, fee, openingHours)
                    gymsList.add(gym)
                } else {
                    // Handle the case where column indices are invalid
                    // Log an error or throw an exception as needed
                }
            }
        }
        db.close()
        return gymsList
    }

    fun deleteGym(id: Int) {
        val db = writableDatabase
        db.delete(TABLE_GYMS, "$COLUMN_ID=?", arrayOf(id.toString()))
        db.close()
    }

    fun findViewById(gymId: Int) {

    }


    data class Gyms(
        val id: Int, // Change the type to Int
        val name: String,
        val location: String,
        val fee: Double,
        val openingHours: String
    )


}
