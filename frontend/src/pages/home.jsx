import { NavBar } from "../components/NavBar";
import { ProductGrid } from "../components/ProductGrid";
import { CategoryMenu } from "../components/CategoryMenu"
import { HeroSection } from "../components/HeroSection";

export function Home() {
    return (
        <div className="bg-[#CCCCCC] min-h-screen flex flex-col w-full">
            <NavBar/>
            <CategoryMenu/>
            <HeroSection/>
            <ProductGrid/>
        </div>
    );
}