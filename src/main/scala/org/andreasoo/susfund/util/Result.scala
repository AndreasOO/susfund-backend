package org.andreasoo.susfund.util

case class Result[T](resultObj:T, error:String ="", success:Boolean=true)

