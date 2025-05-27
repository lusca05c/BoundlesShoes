export function NavBar(){
    return(
        <>
        <div className="bg-[#0F2246] px-4 h-20 w-full flex items-center justify-between border-b-2 border-white">
                
                <div>
                    <img src="././public/brandShoesA.jpg" className="ml-5 rounded-full h-12 w-12 hover:scale-115 transition-transform" alt="logo.png"/>
                </div>

                <div className="flex w-fit">
                    <input type="text" id="searchInput" placeholder="Digite aqui o que procura..." className="bg-white text-[#1C1C1C] w-lg px-6 h-9 rounded-l-4xl focus:outline-none" />
                    <button type="submit" id="searchBtn" className="bg-white h-9 px-4 rounded-r-4xl border-l border-gray-300 cursor-pointer">
                        <img src="././search_16dp_999999_FILL1_wght400_GRAD0_opsz20.svg" alt="Buscar" className="h-full"/>
                    </button>
                </div>

                <div className="flex gap-6 py-2 mr-8">
                    <a href="/carrinho">
                        <img src="././public/shopping_cart_35dp_FFFFFF_FILL1_wght400_GRAD0_opsz40.svg" className="cursor-pointer hover:scale-115 transition-transform" alt="meuCarrinho" />
                    </a>
                    <a href="/user">
                        <img src="././public/person_35dp_FFFFFF_FILL1_wght400_GRAD0_opsz40.svg" className="cursor-pointer hover:scale-115 transition-transform" alt="meuPerfil" />
                    </a>
                </div>

        </div>
        </>
    )
}