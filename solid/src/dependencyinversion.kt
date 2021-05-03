//NAY

class _WidgetContainer(widgetProfis: _WidgetProfis){
    init {
        widgetProfis.show()
    }
}

class _WidgetProfis{
    fun show(){}
}

class _WidgetVersicherung{
    fun show(){}
}


//YAY

interface Widget{
    fun show()
}

class WidgetContainer(widget: Widget){
    init {
        widget.show()
    }
}

class WidgetProfis: Widget{
    override fun show(){}
}

class WidgetVersicherung: Widget{
    override fun show(){}
}