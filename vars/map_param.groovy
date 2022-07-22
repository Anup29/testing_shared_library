def call(Map config){
  def st = ""
  for ( ob in config) {
    println "Key= ${ob.key}, value= ${ob.value}"
    st = st + '--pytest-args="--' +$ob.key + '=' + $ob.value + '"'
  }
  println(st)
}
