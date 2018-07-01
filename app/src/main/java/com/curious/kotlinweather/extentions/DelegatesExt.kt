package com.curious.kotlinweather.extentions

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 对于可变变量属性的委托，必须同时实现getValue和setValue方法
 */
class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {
    var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} is not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value else
            throw IllegalStateException("${property.name} already initialized")
    }
}

/**
 * 单例模式
 */
object DelegatesExt {

    fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()

}