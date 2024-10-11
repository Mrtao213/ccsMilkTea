const alipay = (id)=>{
    return $axios({
        url: 'alipay/pay',
        method: 'get',
        params: id
    })
}
