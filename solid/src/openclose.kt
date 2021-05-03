//NAY
class _Repository(val api: Any){

    fun getUserList(){
        when(api){
            is _UsersREST -> api.getUsers()
            is _UsersGraphQL -> api.getUsers()
//            is _UsersFALCOR -> api.getUsers()
        }
    }

    fun login(){
        val token = when(api){
            is _UsersREST -> api.getToken()
            is _UsersGraphQL -> api.getToken()
//            is _UsersFALCOR -> api.getToken()
            else -> ""
        }

        when(api){
            is _UsersREST -> api.login(token)
            is _UsersGraphQL -> api.login(token)
//            is _UsersFALCOR -> api.login(token)
        }
    }

}

class _UsersREST(){
    fun getUsers(){}
    fun getToken(): String{
        return "213123123124124"
    }
    fun login(token: String){}
}

class _UsersGraphQL(){
    fun getUsers(){}
    fun getToken(): String{
        return "213123123124124"
    }
    fun login(token: String){}
}

//class _UsersFALCOR(){
//    fun getUsers(){}
//    fun getToken(): String{
//        return "213123123124124"
//    }
//    fun login(token: String){}
//}

//YEA

class Repository(val api: UsersApi){

    fun getUserList(){
        api.getUsers()
    }

    fun login(){
        val token = api.getToken()
        api.login(token)
    }

}
interface UsersApi{
    fun getUsers()
    fun getToken(): String
    fun login(token: String)
}

class UsersREST(): UsersApi{
    override fun getUsers(){}
    override fun getToken(): String{
        return "213123123124124"
    }
    override fun login(token: String){}
}

class UsersGraphQL(): UsersApi{
    override fun getUsers(){}
    override fun getToken(): String{
        return "213123123124124"
    }
    override fun login(token: String){}
}

//class UsersFALCOR(): UsersApi{
//    override fun getUsers(){}
//    override fun getToken(): String{
//        return "213123123124124"
//    }
//    override fun login(token: String){}
//}