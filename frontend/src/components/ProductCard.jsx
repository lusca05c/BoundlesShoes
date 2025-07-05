import { IoCartOutline } from "react-icons/io5";

export function ProductCard({product}){

    const insertCartItem = (e) => {
        
        e.preventDefault(); 
        
    };

    return(
        <>
            <a href={`/product/${product.id}`}>
                <div className="bg-white rounded-lg shadow-md overflow-hidden transition hover:scale-105 duration-300 flex flex-col h-full">
                    <div className="w-full h-48 sm:h-56 overflow-hidden">
                        <img src={product.image}
                             alt={product.name}
                             className="w-full h-full object-cover"/>
                    </div>
                    <div className="p-4 flex-grow flex flex-col justify-between">
                        <div className="font-semibold text-lg text-gray-800 line-clamp-2 mb-2">
                            <h3>{product.name}</h3>
                        </div>
                        <div>
                            <div className="text-xl font-bold text-blue-600 mb-2">
                                <p>R$ {product.price.toFixed(2).replace('.',',')}</p>   
                            </div>
                            <p className="text-sm text-gray-500 mb-4">
                                Vendido por: <span className="font-medium">{product.user}</span>
                            </p>
                            <div>
                                <button className="cursor-pointer w-full bg-blue-500 text-white py-2 px-4 rounded-md font-semibold hover:bg-blue-600 transition duration-300 mt-auto
                                               flex items-center justify-center gap-2"
                                        onClick={insertCartItem}>
                                    Adicionar
                                    <IoCartOutline className="text-xl"/>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </a>
        </>
    )
}