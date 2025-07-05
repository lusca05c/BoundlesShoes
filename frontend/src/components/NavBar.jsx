import { IoCartOutline } from "react-icons/io5";
import { VscAccount } from "react-icons/vsc";
import {IconButton} from '@mui/material';
import { InputBase } from "@mui/material";
import { Paper } from '@mui/material';
import { CiSearch } from 'react-icons/ci';
import { Divider } from '@mui/material';

export function NavBar({notHiddenSearch = 1}){
    return(
        <>
        
        <div className="bg-[#CCCCCC] px-3 py-2 h-auto w-full flex flex-col md:flex-row items-center justify-between shadow-sm">
                
                <div className="w-[19rem] flex items-center gap-4 mb-2 md:mb-0">
                    <a
                    href="/"
                    className="flex items-center gap-2 px-2 py-1 text-[#0F2246] font-bold rounded-md"
                    >
                        <img
                        src="/brandShoesA.jpg"
                        className="h-10 w-10 rounded-full object-cover md:h-12 md:w-12"
                        alt="Logo da loja"
                        />  
                        <span className="text-sm md:text-base">BOUNDLES SHOES</span>
                    </a>
                </div>

                {notHiddenSearch && (
                    <div className="w-full flex justify-center flex-grow mb-2 md:mb-0 md:mx-4">
                        <Paper
                        component="form"
                        sx={{ p: '2px 4px', display: 'flex', alignItems: 'center', width: '100%', maxWidth: '500px' }}
                        >
                            <InputBase
                                sx={{ ml: 1, flex: 1 }}
                                placeholder="Digite algum produto"
                                inputProps={{ 'aria-label': 'Digite algum produto' }}
                            />
                            <Divider sx={{ height: 26, m: 0.5 }} orientation="vertical" />
                            <IconButton type="button" sx={{ p: '10px' }} aria-label="search">
                                <CiSearch />
                            </IconButton>
                        </Paper>
                    </div>
                )}

                
                <div className="flex items-center gap-4 md:gap-6 mt-2 md:mt-0">
                    <a href="/carrinho">
                        <IoCartOutline className="text-[#0F2246] text-[1.8rem] md:text-[2rem]"/>
                    </a>
                    <Divider sx={{ height: 26, m: 0 }} orientation="vertical" />
                    <a href="/user">
                        <VscAccount className="text-[#0F2246] text-[1.8rem] md:text-[2rem]"/>
                    </a>
                </div>

        </div>
        </>
    )
}