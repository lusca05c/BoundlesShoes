import { NavBar } from "../components/NavBar";
import { CategoryMenu } from "../components/CategoryMenu";

export function PageWithNavLayout ({children, hideSearchBar = false, hideCategoryMenu = false}) {
    return(
        <div className="h-[88dvh] relative">
            <NavBar notHiddenSearch = {!hideSearchBar}/>
            {!hideCategoryMenu &&(<CategoryMenu/>)}
            <main className="h-full">
                {children}  
            </main>   
        </div>
    );
}