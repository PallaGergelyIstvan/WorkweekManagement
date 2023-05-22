package com.example.workweekmanagement.data

import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class DataEncryption {
    @Throws(NoSuchAlgorithmException::class)
    fun getSHA(input: String): ByteArray {
        val md = MessageDigest.getInstance("SHA-256")
        //89 Character before and 27 Character after it for a total of 116 characters
        val secret =
            "SzuperTitkosJelszoMegborsozvaEsEgyKisSoIsRaEzutanBeASutobeSzazotvenPercreEsMarMajdnemKesz" + input + "MoreSaltHereWithExtraPepper"
        return md.digest(secret.toByteArray(StandardCharsets.UTF_8))
    }

    fun toHexString(hash: ByteArray?): String {
        val number = BigInteger(1, hash)
        val hexString = StringBuilder(number.toString(16))
        while (hexString.length < 64) {
            hexString.insert(0, '0')
        }
        return hexString.toString()
    }
}