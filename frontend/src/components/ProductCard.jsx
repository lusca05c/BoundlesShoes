export function ProductCard({product}){
    return(
        <>
            <a href={`/product/${product.id}`}>
                <div className="bg-[#D9D9D9] rounded-lg shadow-md overflow-hidden transition hover:scale-105 duration-300">
                    <div>
                        <img src={product.image} alt={product.name}/>
                    </div>
                    <div>
                        <div className="p-4 font-semibold text-lg text-gray-600">
                            <h3>{product.name}</h3>
                        </div>
                        <div>
                            <div className="text-gray-800 font-semibold text-sm">
                                <p>R$ {product.price}</p>   
                            </div>
                            <div>
                                <button className="w-full">

                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </a>
        </>
    )
}