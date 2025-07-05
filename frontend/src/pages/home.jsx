import { ProductGrid } from "../components/ProductGrid";
import { HeroSection } from "../components/HeroSection";
import { PageWithNavLayout } from "../layouts/PageWithNav";

export function Home() {
    return (
        <div className="bg-gray-100 min-h-screen flex flex-col w-full">
            <PageWithNavLayout hideSearchBar={false} hideCategoryMenu={false}>
                <HeroSection/>
                <ProductGrid/>
            </PageWithNavLayout>
        </div>
    );
}