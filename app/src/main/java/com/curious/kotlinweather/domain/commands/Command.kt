package com.curious.kotlinweather.domain.commands

public interface Command<T>{
    fun execute():T
}