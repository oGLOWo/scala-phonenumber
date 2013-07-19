package com.oglowo.phonenumber

import scalaz._
import Scalaz._
import com.google.i18n.phonenumbers.{NumberParseException, Phonenumber, PhoneNumberUtil}
import Countries._
import PhoneNumberFormat._

case class PhoneNumber(rawNumber: Option[String] = None, country: Country, protected val underlyingNumber: Phonenumber.PhoneNumber) {
  def format(format: PhoneNumberFormat): String = PhoneNumberUtil.getInstance().format(underlyingNumber, format)

  override def equals(other: Any): Boolean =
    other match {
      case that: PhoneNumber => (that canEqual this) && format(Rfc3966) == that.format(Rfc3966)
      case _ => false
    }

  override def hashCode: Int = Option(underlyingNumber) match {
    case Some(number) => 41 * (41 + format(Rfc3966).hashCode)
    case None => super.hashCode
  }

  override def canEqual(other: Any): Boolean = other.isInstanceOf[PhoneNumber]
}

object PhoneNumber {
  protected def createPhoneNumber(rawNumber: String): Validation[Throwable, PhoneNumber] = {
    try {
      val country = `United States of America`
      val underlyingNumber = PhoneNumberUtil.getInstance().parseAndKeepRawInput(rawNumber, country.isoA2CountryCode)
      PhoneNumber(Some(rawNumber), country, underlyingNumber).success
    }
    catch {
      case e: NumberParseException => e.failure
    }
  }

  def apply(rawNumber: String): Validation[Throwable, PhoneNumber] = {
    createPhoneNumber(rawNumber)
  }
}