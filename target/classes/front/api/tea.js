const selectByCategory = (id)=>{
    return $axios({
        url: '/tea/category',
        method: 'get',
        params: id
    })
}

const queryTeaById = (params)=>{
    return $axios({
        url: '/tea/query',
        method: 'get',
        params: params
    })
}