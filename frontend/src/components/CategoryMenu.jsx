import { MdCategory } from "react-icons/md";
import { useState } from "react";
import { MdFilterList } from "react-icons/md";
import { IoHomeOutline } from "react-icons/io5";
import { Divider } from '@mui/material';

export function CategoryMenu(){

    const [isOpen, setIsOpen] = useState(false);
    const [isFilterOPen, setFilterOpen] = useState(false);

    const toggleCategories = () => {
        setIsOpen(!isOpen);
    }

    const toggleFilter = () => {
        setFilterOpen(!isFilterOPen);
    }

    return(
        <>
            <div className="bg-[#0F2246] h-14 w-full flex items-center px-8 gap-26 text-white text-sm font-medium  z-40">
                
                <div className="relative h-full">
                    <button 
                    onClick={toggleCategories}
                    className="ml-32 h-full flex items-center gap-2 px-6 py-2 bg-orange-500 hover:bg-orange-600 transition cursor-pointer ">
                        <MdCategory className="text-lg" />
                        Categorias
                    </button>
                    <div className={`absolute left-32 mt-0 w-[9rem] bg-orange-500 rounded-b-md text-white z-50 py-2 transition ${
                        isOpen ? "" : "hidden"
                        }`}>
                        {isOpen && (
                            <>
                            <a href="/tenis-masculino" className="block px-4 py-2 hover:bg-orange-600">Tênis Masculino</a>
                            <a href="/tenis-feminino" className="block px-4 py-2 hover:bg-orange-600">Tênis Feminino</a>
                            <a href="/tenis-infantil" className="block px-4 py-2 hover:bg-orange-600">Tênis Infantil</a>
                            <a href="/chinelos" className="block px-4 py-2 hover:bg-orange-600">Chinelos</a>
                            <a href="/bota" className="block px-4 py-2 hover:bg-orange-600">Botas</a>
                            <a href="/acessorios" className="block px-4 py-2 hover:bg-orange-600">Acessórios</a>
                            </>
                        )}
                    </div>

                
                </div>
                
                <div className="flex items-center h-full">
                    <div className="relative h-full">
                        <button 
                        onClick={toggleFilter}
                        className="h-full flex items-center gap-2 px-6 py-2 hover:bg-[#1A3464] transition cursor-pointer" 
                        >
                            <MdFilterList className="text-lg" />
                            Filtrar
                        </button>

                        <div className={`absolute left-0 mt-0 w-[7.12rem] bg-[#0F2246] rounded-b-md text-white z-50 py-2 transition ${
                            isFilterOPen ? "" : "hidden"
                            }`}>
                                <a href="" className="block px-4 py-2 hover:bg-[#1A3464]">Menor Preço</a>
                                <a href="" className="block px-4 py-2 hover:bg-[#1A3464]">Maior Preço</a>
                        </div>

                    </div>
                            
                    <div className="px-1">
                        <Divider className="h-5 bg-white w-[0.01rem]"/>
                    </div>

                    <a
                    href="/"
                    className="h-full flex items-center gap-2 px-6 py-2 hover:bg-[#1A3464]"
                    >
                        <IoHomeOutline className="text-lg"/>
                        Home
                    </a>

                </div>
            </div>
        </>
    )
}