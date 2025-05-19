import { BrowserRouter, Route, Routes } from "react-router-dom";
import Pages from "./Pages";



function App(){

    
    <BrowserRouter>
        <Routes>
            {
                Pages.map((Pages, index) => (<Route key = {index} path = {Pages.path} element = {Pages.component} />))
            }
        </Routes>
    </BrowserRouter>

}

export default App;