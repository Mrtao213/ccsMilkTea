(function (win){
    axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'

    const service = axios.create({
            baseURL: '/',
            timeout: 1000000
    }
    )
    win.$axios = service
})(window)