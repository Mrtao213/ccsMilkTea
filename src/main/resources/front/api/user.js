const updateUser = (user)=>{
    return $axios({
        url: '/user/update',
        method: 'put',
        data: user
    })
}

const queryUserById = (id)=>{
    return $axios({
        url: '/user/query',
        method: 'get',
        params: id
    })
}