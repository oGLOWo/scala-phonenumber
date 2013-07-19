package com.oglowo.phonenumber

import com.oglowo.phonenumber._

case class Country(name: String,
                   internationalDirectDialingCode: InternationalDirectDialingCode,
                   telephoneTrunkCode: CountryTelephoneTrunkCode,
                   nanpAreaCode: Option[NorthAmericanNumberingPlanAreaCode],
                   isoA2CountryCode: IsoAlpha2CountryCode,
                   isoA3CountryCode: IsoAlpha3CountryCode,
                   isoM49CountryCode: IsoM49CountryCode) {

}

object Countries {
  val `United States of America` = Country("United States of America", "011", 1, None, "US", "USA", "840")
}