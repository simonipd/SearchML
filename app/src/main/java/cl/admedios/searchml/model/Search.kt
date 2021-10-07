package cl.admedios.searchml.model

import android.os.Parcelable
import com.google.gson.JsonArray
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseSearch (
        @SerializedName("site_id")
        val siteID: String,

        @SerializedName("country_default_time_zone")
        val countryDefaultTimeZone: String,

        val query: String,
        val paging: Paging,
        val results: MutableList<Result>,
        val sort: Sort,

        @SerializedName("available_sorts")
        val availableSorts: List<Sort>,


        @SerializedName("available_filters")
        val availableFilters: List<AvailableFilter>
): Parcelable

@Parcelize
data class AvailableFilter (
        val id: String,
        val name: String,
        val type: String,
        val values: List<AvailableFilterValue>
): Parcelable

@Parcelize
data class AvailableFilterValue (
        val id: String,
        val name: String,
        val results: Long
): Parcelable

@Parcelize
data class Sort (
        val id: String,
        val name: String
): Parcelable

@Parcelize
data class Paging (
        val total: Long,

        @SerializedName("primary_results")
        val primaryResults: Long,

        val offset: Long,
        val limit: Long
): Parcelable

@Parcelize
data class Result (
        val id: String,

        @SerializedName("site_id")
        val siteID: String,

        val title: String,
        val seller: Seller,
        val price: Float,
        val prices: Prices,



        @SerializedName("currency_id")
        val currencyID: String,

        @SerializedName("available_quantity")
        val availableQuantity: Long,

        @SerializedName("sold_quantity")
        val soldQuantity: Long,

        @SerializedName("buying_mode")
        val buyingMode: String,

        @SerializedName("listing_type_id")
        val listingTypeID: String,

        @SerializedName("stop_time")
        val stopTime: String,

        val condition: String,
        val permalink: String,
        val thumbnail: String,

        @SerializedName("thumbnail_id")
        val thumbnailID: String,

        @SerializedName("accepts_mercadopago")
        val acceptsMercadopago: Boolean,

        val installments: Installments,
        val address: Address,
        val shipping: Shipping,

        @SerializedName("seller_address")
        val sellerAddress: SellerAddress,

        val attributes: List<Attribute>,

        @SerializedName("original_price")
        val originalPrice: Long,

        @SerializedName("category_id")
        val categoryID: String,

        @SerializedName("official_store_id")
        val officialStoreID: Long,

        @SerializedName("domain_id")
        val domainID: String,

        @SerializedName("catalog_product_id")
        val catalogProductID: String,

        val tags: List<String>,

        @SerializedName("catalog_listing")
        val catalogListing: Boolean,

        @SerializedName("use_thumbnail_id")
        val useThumbnailID: Boolean,





        @SerializedName("order_backend")
        val orderBackend: Long
): Parcelable

@Parcelize
data class Address (
        @SerializedName("state_id")
        val stateID: String,

        @SerializedName("state_name")
        val stateName: String,

        @SerializedName("city_id")
        val cityID: String,

        @SerializedName("city_name")
        val cityName: String
): Parcelable

@Parcelize
data class Attribute (
        val source: Long,
        val id: String,
        val name: String,

        @SerializedName("value_struct")
        val valueStruct: Struct? = null,

        val values: List<AttributeValue>,

        @SerializedName("attribute_group_id")
        val attributeGroupID: String,

        @SerializedName("attribute_group_name")
        val attributeGroupName: String,

        @SerializedName("value_id")
        val valueID: String? = null,

        @SerializedName("value_name")
        val valueName: String
): Parcelable

@Parcelize
data class Struct (
        val number: Float,
        val unit: String
): Parcelable

@Parcelize
data class AttributeValue (
        val name: String,
        val struct: Struct? = null,
        val source: Long,
        val id: String? = null
): Parcelable

@Parcelize
data class Installments (
        val quantity: Long,
        val amount: Float,
        val rate: Long,

        @SerializedName("currency_id")
        val currencyID: String
): Parcelable

@Parcelize
data class Prices (
        val id: String,
        val prices: List<Price>,
        val presentation: Presentation




): Parcelable

@Parcelize
data class Presentation (
        @SerializedName("display_currency")
        val displayCurrency: String
): Parcelable

@Parcelize
data class Price (
        val id: String,
        val type: String,
        val amount: Float,

        @SerializedName("regular_amount")
        val regularAmount: Float? = null,

        @SerializedName("currency_id")
        val currencyID: String,

        @SerializedName("last_updated")
        val lastUpdated: String,

        val conditions: Conditions,

        @SerializedName("exchange_rate_context")
        val exchangeRateContext: String,

        val metadata: Metadata
): Parcelable

@Parcelize
data class Conditions (
        @SerializedName("context_restrictions")
        val contextRestrictions: List<String>,

        @SerializedName("start_time")
        val startTime: String? = null,

        @SerializedName("end_time")
        val endTime: String? = null,

        val eligible: Boolean
): Parcelable

@Parcelize
data class Metadata (
        @SerializedName("campaign_id")
        val campaignID: String? = null,

        @SerializedName("promotion_id")
        val promotionID: String? = null,

        @SerializedName("promotion_type")
        val promotionType: String? = null
): Parcelable

@Parcelize
data class Seller (
        val id: Long,




        @SerializedName("car_dealer")
        val carDealer: Boolean,

        @SerializedName("real_estate_agency")
        val realEstateAgency: Boolean,




): Parcelable

@Parcelize
data class SellerAddress (
        val id: String,
        val comment: String,

        @SerializedName("address_line")
        val addressLine: String,

        @SerializedName("zip_code")
        val zipCode: String,

        val country: Sort,
        val state: Sort,
        val city: Sort,
        val latitude: String,
        val longitude: String
): Parcelable

@Parcelize
data class Shipping (
        @SerializedName("free_shipping")
        val freeShipping: Boolean,

        val mode: String,
        val tags: List<String>,

        @SerializedName("logistic_type")
        val logisticType: String,

        @SerializedName("store_pick_up")
        val storePickUp: Boolean
): Parcelable
