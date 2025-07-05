import { ProductCard } from './ProductCard';

const exampleProducts = [
];


export function ProductGrid() {

    return (
        <div className="bg-gray-100 mx-auto py-8 px-22 w-full">
            <h2 className="text-3xl font-bold text-gray-800 text-center mb-8">Nossos Destaques</h2>
            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-10">
                {exampleProducts.map(product => (
                    <ProductCard key={product.id} product={product} />
                ))}
            </div>
        </div>
    );
}