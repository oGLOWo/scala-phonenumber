package com.oglowo.phonenumber

object PhoneNumberFormat extends Enumeration {
  type PhoneNumberFormat = Value
  val E164, International, National, Rfc3966 = Value
}
import PhoneNumberFormat._
