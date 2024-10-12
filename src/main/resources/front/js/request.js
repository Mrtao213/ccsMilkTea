(function (win){
    axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'

    const service = axios.create({
            baseURL: '/',
            timeout: 1000000
    }
    )

    service.interceptors.response.use(res => {
            console.log('---响应拦截器---',res)
            // 未设置状态码则默认成功状态
            const code = res.data.code;
            // 获取错误信息
            const msg = res.data.msg
            console.log('---code---',code)
            if (res.data.code === 0 && res.data.msg === 'NOTLOGIN') {// 返回登录页面
                console.log('---/front/page/login/login.html---',code)
                localStorage.removeItem('user')
                window.top.location.href = '/front/page/login/login.html'
            } else {
                return res
            }
        })

    win.$axios = service
})(window)