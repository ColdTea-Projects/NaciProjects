//NAY
interface _Network{
    fun connect()
    fun passwordConfirmation()
    fun fetchToken()
}

class _Line: _Network{
    override fun connect() {
        // connect stuff
    }

    override fun passwordConfirmation() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetchToken() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class _SecureLine: _Network{
    override fun connect() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun passwordConfirmation() {
        // passwordConfirmation stuff
    }

    override fun fetchToken() {
        // fetchToken stuff
    }

}

//YEA

interface Network{
    fun connect()
}

interface SecureNetwork :Network{
    fun passwordConfirmation()
    fun fetchToken()
}

class Line: Network{
    override fun connect() {
        // connect
    }
}

class SecureLine: SecureNetwork{
    override fun connect() {
        passwordConfirmation()
        fetchToken()
        //connect stuff
    }

    override fun passwordConfirmation() {
        // passwordConfirmation stuff
    }

    override fun fetchToken() {
        // fetchToken stuff
    }

}