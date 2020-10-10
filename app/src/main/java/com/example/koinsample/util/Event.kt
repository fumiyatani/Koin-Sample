package com.example.koinsample.util

class Event<out T>(private val content: T) {
    var hasBeenHandled = false
        private set // 外部にはgetterのみを公開して値を更新させないようにする

    /**
     * 値を受け取っていない場合はコンストラクタで渡した値を取得する
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * フラグにかかわらず値を取得する
     */
    fun peekContent() = content
}