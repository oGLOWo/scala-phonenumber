package com.oglowo.phonenumber

class Country(val name: String,
              val internationalDirectDialingCode: InternationalDirectDialingCode,
              val telephoneTrunkCode: CountryTelephoneTrunkCode,
              val nanpAreaCode: Option[NorthAmericanNumberingPlanAreaCode],
              val isoA2CountryCode: IsoAlpha2CountryCode,
              val isoA3CountryCode: IsoAlpha3CountryCode,
              val isoM49CountryCode: IsoM49CountryCode) {

}

object Country {
  def apply(name: String,
            internationalDirectDialingCode: InternationalDirectDialingCode,
            telephoneTrunkCode: CountryTelephoneTrunkCode,
            nanpAreaCode: Option[NorthAmericanNumberingPlanAreaCode],
            isoA2CountryCode: IsoAlpha2CountryCode,
            isoA3CountryCode: IsoAlpha3CountryCode,
            isoM49CountryCode: IsoM49CountryCode) = new Country(name, internationalDirectDialingCode, telephoneTrunkCode, nanpAreaCode, isoA2CountryCode, isoA3CountryCode, isoM49CountryCode)
}

object Countries {
  val `United States of America` = Country("United States of America", "011", 1, None, "US", "USA", "840")
}