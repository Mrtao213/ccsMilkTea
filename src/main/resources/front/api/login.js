const login = (params)=>{
    return $axios({
        url: '/user/login',
        method: 'post',
        data: params
    })
}
const logoutApi = ()=>{
    return $axios({
        url: '/user/logout',
        method: 'post',
    })
}