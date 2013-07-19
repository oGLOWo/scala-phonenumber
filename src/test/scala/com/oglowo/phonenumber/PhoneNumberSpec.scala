package com.oglowo.phonenumber

import org.specs2.mutable._
import scalaz._
import Scalaz._
import java.lang.Throwable
import org.specs2.execute
import org.specs2.execute.{Error, ErrorException}
import PhoneNumberFormat._

class PhoneNumberSpec extends Specification {
  val UnitedStatesValidRawNumber = "2134485916"
  val UnitedStatesValidRawNumberTwo = "3234243159"
  val UnitedStatesValidInternationalFormattedNumber = "+1 213-448-5916"
  val UnitedStatesValidNationalFormattedNumber = "(213) 448-5916"
  val UnitedStatesValidE164FormattedNumber = "+12134485916"
  val UnitedStatesValidRfc3966FormattedNumber = "+1-213-448-5916"

  "PhoneNumber" should {
    s"Succeed in parsing '$UnitedStatesValidRawNumber' " in {
      PhoneNumber(UnitedStatesValidRawNumber) must beLike {
        case Success(s) => s must beAnInstanceOf[PhoneNumber]
        case Failure(f) => f must beAnInstanceOf[Throwable]
      }
    }

    s"Format $UnitedStatesValidRawNumber as $UnitedStatesValidInternationalFormattedNumber with format ${International.toString}" in {
      PhoneNumber(UnitedStatesValidRawNumber) match {
        case Success(s) => s.format(International) must beEqualTo(UnitedStatesValidInternationalFormattedNumber)
        case Failure(f) => throw new ErrorException(Error(f))
      }
    }

    s"Format $UnitedStatesValidRawNumber as $UnitedStatesValidNationalFormattedNumber with format ${National.toString}" in {
      PhoneNumber(UnitedStatesValidRawNumber) match {
        case Success(s) => s.format(National) must beEqualTo(UnitedStatesValidNationalFormattedNumber)
        case Failure(f) => throw new ErrorException(Error(f))
      }
    }

    s"Format $UnitedStatesValidRawNumber as $UnitedStatesValidE164FormattedNumber with format ${E164.toString}" in {
      PhoneNumber(UnitedStatesValidRawNumber) match {
        case Success(s) => s.format(E164) must beEqualTo(UnitedStatesValidE164FormattedNumber)
        case Failure(f) => throw new ErrorException(Error(f));
      }
    }

    s"Format $UnitedStatesValidRawNumber as $UnitedStatesValidRfc3966FormattedNumber with format ${Rfc3966.toString}" in {
      PhoneNumber(UnitedStatesValidRawNumber) match {
        case Success(s) => s.format(Rfc3966) must beEqualTo(UnitedStatesValidRfc3966FormattedNumber)
        case Failure(f) => throw new ErrorException(Error(f))
      }
    }

    "return the same hashCode for 2 phone numbers with equivalent but differently formatted raw input" in {
      val phoneNumberOne = PhoneNumber(UnitedStatesValidRawNumber) match {
        case Success(s) => s
        case Failure(f) => throw new ErrorException(Error(f))
      }

      val phoneNumberTwo = PhoneNumber(UnitedStatesValidInternationalFormattedNumber) match {
        case Success(s) => s
        case Failure(f) => throw new ErrorException(Error(f))
      }

      phoneNumberOne.hashCode must beEqualTo(phoneNumberTwo.hashCode)
    }

    "produce true when calling equals on 2 phone number objects with equivalent but differently formatted raw input" in {
      val phoneNumberOne = PhoneNumber(UnitedStatesValidRawNumber) match {
        case Success(s) => s
        case Failure(f) => throw new ErrorException(Error(f))
      }

      val phoneNumberTwo = PhoneNumber(UnitedStatesValidNationalFormattedNumber) match {
        case Success(s) => s
        case Failure(f) => throw new ErrorException(Error(f))
      }

      phoneNumberOne.equals(phoneNumberTwo) must beTrue
    }

    "produce true when calling canEqual on two phone number objects" in {
      val phoneNumberOne = PhoneNumber(UnitedStatesValidRawNumber) match {
        case Success(s) => s
        case Failure(f) => throw new ErrorException(Error(f))
      }

      val phoneNumberTwo = PhoneNumber(UnitedStatesValidNationalFormattedNumber) match {
        case Success(s) => s
        case Failure(f) => throw new ErrorException(Error(f))
      }

      phoneNumberOne.canEqual(phoneNumberTwo) must beTrue
    }

    "return different hashCodes for 2 different phone numbers" in {
      val phoneNumberOne = PhoneNumber(UnitedStatesValidRawNumber) match {
        case Success(s) => s
        case Failure(f) => throw new ErrorException(Error(f))
      }

      val phoneNumberTwo = PhoneNumber(UnitedStatesValidRawNumberTwo) match {
        case Success(s) => s
        case Failure(f) => throw new ErrorException(Error(f))
      }

      phoneNumberOne.hashCode must not be equalTo(phoneNumberTwo.hashCode)
    }

    "produce false when calling equals on 2 different phone numbers" in {
      val phoneNumberOne = PhoneNumber(UnitedStatesValidRawNumber) match {
        case Success(s) => s
        case Failure(f) => throw new ErrorException(Error(f))
      }

      val phoneNumberTwo = PhoneNumber(UnitedStatesValidRawNumberTwo) match {
        case Success(s) => s
        case Failure(f) => throw new ErrorException(Error(f))
      }

      phoneNumberOne.equals(phoneNumberTwo) must beFalse
    }

    "produce false when calling canEqual on a phone number object and a non-phone number object" in {
      val phoneNumber = PhoneNumber(UnitedStatesValidRawNumber) match {
        case Success(s) => s
        case Failure(f) => throw new ErrorException(Error(f))
      }

      val theNumberSeven = 7

      phoneNumber.canEqual(theNumberSeven) must beFalse
    }
  }
}
