package com.oglowo

import scala.language.implicitConversions
import com.oglowo.phonenumber.PhoneNumberFormat._
import com.google.i18n.phonenumbers.PhoneNumberUtil.{PhoneNumberFormat => GooglePhoneNumberFormat}

package object phonenumber {
  type StringPreconditionPredicate = String => Boolean
  class StringWithPrecondition(val underlying: String, predicate: StringPreconditionPredicate) {
    require(predicate(underlying))
  }

  type IntPreconditionPredicate = Int => Boolean
  class IntWithPrecondition(val underlying: Int, predicate: IntPreconditionPredicate) {
    require(predicate(underlying))
  }

  case class ThreeDigitInt(override val underlying: Int) extends IntWithPrecondition(underlying, _.toString.takeWhile(_ == '0').length == 3)
  case class String3(override val underlying: String) extends StringWithPrecondition(underlying, string => string.length == 3)
  case class String2(override val underlying: String) extends StringWithPrecondition(underlying, string => string.length == 2)
  case class MaxString4(override val underlying: String) extends StringWithPrecondition(underlying, string => 1 to 4 contains string.length)
  case class MaxString3(override val underlying: String) extends StringWithPrecondition(underlying, string => 1 to 3 contains string.length)

  implicit def StringWithPrecondition2String(string: StringWithPrecondition) = string.underlying
  implicit def IntWithPrecondition2Int(value: IntWithPrecondition) = value.underlying
  implicit def Int2ThreeDigitInt(value: Int) = ThreeDigitInt(value)
  implicit def String2String2(string: String) = String2(string)
  implicit def String2String3(string: String) = String3(string)
  implicit def String2MaxString4(string: String) = MaxString4(string)
  implicit def String2MaxString3(string: String) = MaxString3(string)

  type InternationalDirectDialingCode = MaxString4
  type CountryTelephoneTrunkCode = Int
  type NorthAmericanNumberingPlanAreaCode = ThreeDigitInt
  type IsoAlpha2CountryCode = String2
  type IsoAlpha3CountryCode = String3
  type IsoM49CountryCode = String3

  implicit def PhoneNumberFormat2GooglePhoneNumberFormat(format: PhoneNumberFormat): GooglePhoneNumberFormat = format match {
    case E164 => GooglePhoneNumberFormat.E164
    case International => GooglePhoneNumberFormat.INTERNATIONAL
    case National => GooglePhoneNumberFormat.NATIONAL
    case Rfc3966 => GooglePhoneNumberFormat.RFC3966
  }
}
