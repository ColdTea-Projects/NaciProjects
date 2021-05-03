open class TouchListener{

    open fun onTriggered(x: Int, y: Int) {
        print("Clicked on the coordinates -> $x, $y")
    }

}

class DoubleClickListener: TouchListener() {
    val waitingTime: Int? = null

    override fun onTriggered(x: Int, y: Int) {
        if(waitingTime != null && waitingTime <= 3) print("Double ")
        super.onTriggered(x, y)
    }

    companion object{
        private const val THRESHOLD = 3
    }
}

//This ain't gonna work

class DragAndDropListener: TouchListener(){

    fun onTriggered(x: Int, y: Int, endX: Int, endY: Int) {
        super.onTriggered(x, y)
    }

}



