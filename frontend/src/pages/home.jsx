import { NavBar } from "../components/NavBar";
import { NavPage } from "../components/NavPage";
import { NavLeftBar } from "../components/NavLeftBar"

export function Home() {
    return (
        <div className="bg-[#EFE9DC] min-h-screen flex flex-col w-full">
            <NavBar/>
            <div className="flex h-full gap-6">
                <NavLeftBar/>
                <NavPage/>
            </div>
        </div>
    );
}