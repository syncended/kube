package dev.syncended.kube.htmx.modifier

import dev.syncended.kube.core.component.Modifier
import dev.syncended.kube.core.model.Selector
import dev.syncended.kube.htmx.model.HxSwap

internal val Modifier.hxGet: String? get() = get("hxGet")
internal val Modifier.hxPost: String? get() = get("hxPost")
internal val Modifier.hxPut: String? get() = get("hxPut")
internal val Modifier.hxDelete: String? get() = get("hxDelete")
internal val Modifier.hxTarget: Selector? get() = get("hxTarget")
internal val Modifier.hxIndicator: Selector? get() = get("hxIndicator")
internal val Modifier.hxSwap: HxSwap? get() = get("hxSwap")
internal val Modifier.hxTrigger: String? get() = get("hxTrigger")

fun Modifier.hxGet(value: String): Modifier = set("hxGet", value)
fun Modifier.hxPost(value: String): Modifier = set("hxPost", value)
fun Modifier.hxPut(value: String): Modifier = set("hxPut", value)
fun Modifier.hxDelete(value: String): Modifier = set("hxDelete", value)
fun Modifier.hxTarget(value: Selector): Modifier = set("hxTarget", value)
fun Modifier.hxIndicator(value: Selector): Modifier = set("hxIndicator", value)
fun Modifier.hxSwap(value: HxSwap): Modifier = set("hxSwap", value)
fun Modifier.hxTrigger(value: String): Modifier = set("hxTrigger", value)
