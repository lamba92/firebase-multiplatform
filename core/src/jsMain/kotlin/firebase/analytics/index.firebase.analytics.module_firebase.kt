@file:JsQualifier("firebase.analytics")
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS",
    "EXTERNAL_DELEGATION"
)

package firebase.analytics

import firebase.app.App
import kotlin.js.Json

external interface `T$9` {
    var currency: Any?
        get() = definedExternally
        set(value) = definedExternally
    var value: Any?
        get() = definedExternally
        set(value) = definedExternally
    var items: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$10` {
    var currency: Any?
        get() = definedExternally
        set(value) = definedExternally
    var coupon: Any?
        get() = definedExternally
        set(value) = definedExternally
    var value: Any?
        get() = definedExternally
        set(value) = definedExternally
    var items: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$11` {
    var currency: Any?
        get() = definedExternally
        set(value) = definedExternally
    var coupon: Any?
        get() = definedExternally
        set(value) = definedExternally
    var value: Any?
        get() = definedExternally
        set(value) = definedExternally
    var items: Any?
        get() = definedExternally
        set(value) = definedExternally
    var checkout_step: Any?
        get() = definedExternally
        set(value) = definedExternally
    var checkout_option: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$12` {
    var description: Any?
        get() = definedExternally
        set(value) = definedExternally
    var fatal: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$13` {
    var value: Any?
        get() = definedExternally
        set(value) = definedExternally
    var currency: Any?
        get() = definedExternally
        set(value) = definedExternally
    var transaction_id: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$14` {
    var method: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$15` {
    var page_title: String?
        get() = definedExternally
        set(value) = definedExternally
    var page_location: String?
        get() = definedExternally
        set(value) = definedExternally
    var page_path: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$16` {
    var value: Any?
        get() = definedExternally
        set(value) = definedExternally
    var currency: Any?
        get() = definedExternally
        set(value) = definedExternally
    var transaction_id: Any
    var tax: Any?
        get() = definedExternally
        set(value) = definedExternally
    var shipping: Any?
        get() = definedExternally
        set(value) = definedExternally
    var items: Any?
        get() = definedExternally
        set(value) = definedExternally
    var coupon: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$17` {
    var value: Any?
        get() = definedExternally
        set(value) = definedExternally
    var currency: Any?
        get() = definedExternally
        set(value) = definedExternally
    var transaction_id: Any
    var tax: Any?
        get() = definedExternally
        set(value) = definedExternally
    var shipping: Any?
        get() = definedExternally
        set(value) = definedExternally
    var items: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$18` {
    var app_name: String
    var screen_name: Any
    var app_id: String?
        get() = definedExternally
        set(value) = definedExternally
    var app_version: String?
        get() = definedExternally
        set(value) = definedExternally
    var app_installer_id: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$19` {
    var search_term: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$20` {
    var items: Any?
        get() = definedExternally
        set(value) = definedExternally
    var promotions: Any?
        get() = definedExternally
        set(value) = definedExternally
    var content_type: Any?
        get() = definedExternally
        set(value) = definedExternally
    var content_id: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$21` {
    var checkout_step: Any?
        get() = definedExternally
        set(value) = definedExternally
    var checkout_option: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$22` {
    var method: Any?
        get() = definedExternally
        set(value) = definedExternally
    var content_type: Any?
        get() = definedExternally
        set(value) = definedExternally
    var content_id: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$23` {
    var name: String
    var value: Number
    var event_category: String?
        get() = definedExternally
        set(value) = definedExternally
    var event_label: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$24` {
    var items: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$25` {
    var promotions: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Analytics {
    var app: App
    fun logEvent(
        eventName: String /* 'add_payment_info' */,
        eventParams: Json? = definedExternally,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun logEvent(eventName: String, eventParams: `T$9`, options: AnalyticsCallOptions? = definedExternally)
    fun logEvent(
        eventName: String /* 'begin_checkout' */,
        eventParams: `T$10`,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun logEvent(
        eventName: String /* 'checkout_progress' */,
        eventParams: `T$11`,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun logEvent(
        eventName: String /* 'exception' */,
        eventParams: `T$12`,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun logEvent(
        eventName: String /* 'generate_lead' */,
        eventParams: `T$13`,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun logEvent(eventName: String, eventParams: `T$14`, options: AnalyticsCallOptions? = definedExternally)
    fun logEvent(
        eventName: String /* 'page_view' */,
        eventParams: `T$15`,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun logEvent(
        eventName: String /* 'purchase' */,
        eventParams: `T$16`,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun logEvent(
        eventName: String /* 'refund' */,
        eventParams: `T$17`,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun logEvent(
        eventName: String /* 'screen_view' */,
        eventParams: `T$18`,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun logEvent(eventName: String, eventParams: `T$19`, options: AnalyticsCallOptions? = definedExternally)
    fun logEvent(
        eventName: String /* 'select_content' */,
        eventParams: `T$20`,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun logEvent(
        eventName: String /* 'set_checkout_option' */,
        eventParams: `T$21`,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun logEvent(
        eventName: String /* 'share' */,
        eventParams: `T$22`,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun logEvent(
        eventName: String /* 'timing_complete' */,
        eventParams: `T$23`,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun logEvent(eventName: String, eventParams: `T$24`, options: AnalyticsCallOptions? = definedExternally)
    fun logEvent(
        eventName: String /* 'view_promotion' */,
        eventParams: `T$25`,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun logEvent(
        eventName: CustomEventName<String>,
        eventParams: Json? = definedExternally,
        options: AnalyticsCallOptions? = definedExternally
    )

    fun setCurrentScreen(screenName: String, options: AnalyticsCallOptions? = definedExternally)
    fun setUserId(id: String, options: AnalyticsCallOptions? = definedExternally)
    fun setUserProperties(properties: CustomParams, options: AnalyticsCallOptions? = definedExternally)
    fun setAnalyticsCollectionEnabled(enabled: Boolean)
}

external interface AnalyticsCallOptions {
    var global: Boolean
}

external interface SettingsOptions {
    var gtagName: String?
        get() = definedExternally
        set(value) = definedExternally
    var dataLayerName: String?
        get() = definedExternally
        set(value) = definedExternally
}

external fun settings(settings: SettingsOptions)

external interface ControlParams {
    var groups: dynamic /* String | Array<String> */
        get() = definedExternally
        set(value) = definedExternally
    var send_to: dynamic /* String | Array<String> */
        get() = definedExternally
        set(value) = definedExternally
    var event_callback: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var event_timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface EventParams {
    var checkout_option: String?
        get() = definedExternally
        set(value) = definedExternally
    var checkout_step: Number?
        get() = definedExternally
        set(value) = definedExternally
    var content_id: String?
        get() = definedExternally
        set(value) = definedExternally
    var content_type: String?
        get() = definedExternally
        set(value) = definedExternally
    var coupon: String?
        get() = definedExternally
        set(value) = definedExternally
    var currency: String?
        get() = definedExternally
        set(value) = definedExternally
    var description: String?
        get() = definedExternally
        set(value) = definedExternally
    var fatal: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var items: Array<Item>?
        get() = definedExternally
        set(value) = definedExternally
    var method: String?
        get() = definedExternally
        set(value) = definedExternally
    var number: String?
        get() = definedExternally
        set(value) = definedExternally
    var promotions: Array<Promotion>?
        get() = definedExternally
        set(value) = definedExternally
    var screen_name: String?
        get() = definedExternally
        set(value) = definedExternally
    var search_term: String?
        get() = definedExternally
        set(value) = definedExternally
    var shipping: dynamic /* String | Number */
        get() = definedExternally
        set(value) = definedExternally
    var tax: dynamic /* String | Number */
        get() = definedExternally
        set(value) = definedExternally
    var transaction_id: String?
        get() = definedExternally
        set(value) = definedExternally
    var value: Number?
        get() = definedExternally
        set(value) = definedExternally
    var event_label: String?
        get() = definedExternally
        set(value) = definedExternally
    var event_category: String
}

external interface CustomParams

external enum class EventName {
    ADD_PAYMENT_INFO /* = 'add_payment_info' */,
    ADD_TO_CART /* = 'add_to_cart' */,
    ADD_TO_WISHLIST /* = 'add_to_wishlist' */,
    BEGIN_CHECKOUT /* = 'begin_checkout' */,
    CHECKOUT_PROGRESS /* = 'checkout_progress' */,
    EXCEPTION /* = 'exception' */,
    GENERATE_LEAD /* = 'generate_lead' */,
    LOGIN /* = 'login' */,
    PAGE_VIEW /* = 'page_view' */,
    PURCHASE /* = 'purchase' */,
    REFUND /* = 'refund' */,
    REMOVE_FROM_CART /* = 'remove_from_cart' */,
    SCREEN_VIEW /* = 'screen_view' */,
    SEARCH /* = 'search' */,
    SELECT_CONTENT /* = 'select_content' */,
    SET_CHECKOUT_OPTION /* = 'set_checkout_option' */,
    SHARE /* = 'share' */,
    SIGN_UP /* = 'sign_up' */,
    TIMING_COMPLETE /* = 'timing_complete' */,
    VIEW_ITEM /* = 'view_item' */,
    VIEW_ITEM_LIST /* = 'view_item_list' */,
    VIEW_PROMOTION /* = 'view_promotion' */,
    VIEW_SEARCH_RESULTS /* = 'view_search_results' */
}

external interface Item {
    var brand: String?
        get() = definedExternally
        set(value) = definedExternally
    var category: String?
        get() = definedExternally
        set(value) = definedExternally
    var creative_name: String?
        get() = definedExternally
        set(value) = definedExternally
    var creative_slot: String?
        get() = definedExternally
        set(value) = definedExternally
    var id: String?
        get() = definedExternally
        set(value) = definedExternally
    var location_id: String?
        get() = definedExternally
        set(value) = definedExternally
    var name: String?
        get() = definedExternally
        set(value) = definedExternally
    var price: dynamic /* String | Number */
        get() = definedExternally
        set(value) = definedExternally
    var quantity: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Promotion {
    var creative_name: String?
        get() = definedExternally
        set(value) = definedExternally
    var creative_slot: String?
        get() = definedExternally
        set(value) = definedExternally
    var id: String?
        get() = definedExternally
        set(value) = definedExternally
    var name: String?
        get() = definedExternally
        set(value) = definedExternally
}