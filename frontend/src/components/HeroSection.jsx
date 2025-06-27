export function HeroSection(){
    return(
        <>
            <div className="bg-white py-16">
  <div className="max-w-7xl mx-auto flex flex-col md:flex-row items-center gap-8 px-6">
    <div className="flex-1">
      <h1 className="text-4xl font-bold text-gray-800">Best Collection For Home Decoration</h1>
      <p className="text-gray-600 mt-4">Lorem ipsum dolor sit amet...</p>
      <button className="mt-6 px-6 py-2 bg-red-500 text-white rounded hover:bg-red-600 transition">Shop Now</button>
    </div>
    <div className="flex-1">
      <img src="/hero-img.jpg" alt="Sofá e planta" className="w-full rounded" />
    </div>
  </div>
</div>

        </>
    )
}