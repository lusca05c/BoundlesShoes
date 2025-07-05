import { Route, Routes} from 'react-router-dom'
import { Pages} from './src/index'

export function Router(){

    return(

        <Routes>
            <Route path="/" element={<Pages.Home/>}/>
            <Route path="/login" element={<Pages.Login/>}/>
            <Route path="/user-perfil" element={<Pages.UserPerfil/>}/>
            <Route path="/user-cadastro" element={<Pages.UserCadastro/>}/>
            <Route path="/recadastro-senha" element={<Pages.PasswordRecadastro/>}/>
            <Route path="/email-para-senha" element={<Pages.RecuperarSenha/>}/>
        </Routes>

    );

}