const loginSystem = (params)=>{
    return $axios({
        url: '/employee/login',
        method: 'post',
        data: params
    })
}

const logoutApi = ()=>{
    return $axios({
        url: 'employee/logout',
        method: 'post'
    })
}