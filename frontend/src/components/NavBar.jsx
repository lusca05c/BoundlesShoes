import { IoCartOutline } from "react-icons/io5";
import { VscAccount } from "react-icons/vsc";
import {IconButton} from '@mui/material';
import { InputBase } from "@mui/material";
import { Paper } from '@mui/material';
import { CiSearch } from 'react-icons/ci';
import { Divider } from '@mui/material';

export function NavBar(){
    return(
        <>
        <div className="bg-[#CCCCCC] px-4 h-16 w-full flex items-center space-x-52 shadow-sm mr-6">
                
                <div className="flex items-center gap-4">
                    <a
                    href="/"
                    className="flex items-center gap-2 px-4 py-2 text-[#0F2246] font-bold rounded-md"
                    >
                        <img
                        src="/brandShoesA.jpg"
                        className="h-12 w-12 rounded-full object-cover"
                        alt="Logo da loja"
                        />  
                        BOUNDLES SHOES
                    </a>
                </div>

                <div>
                    <Paper
                    component="form"
                    sx={{ p: '2px 4px', display: 'flex', alignItems: 'center', width: 400 }}
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

                <div className="flex items-center gap-6 ml-40">
                    <a href="/carrinho">
                        <IoCartOutline className="text-[#0F2246] text-[2rem]"/>
                    </a>
                    <Divider sx={{ height: 26, m: 0 }} orientation="vertical" />
                    <a href="/user">
                        <VscAccount className="text-[#0F2246] text-[2rem]"/>
                    </a>
                </div>

        </div>
        </>
    )
}