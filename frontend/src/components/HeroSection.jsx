export function HeroSection(){
    
  const handleScrollBottom = () => {
    const heroSection = document.getElementById("hero-section");
    if(heroSection){
      window.scroll({
        top: (heroSection.offsetTop + heroSection.offsetHeight),
        behavior: 'smooth'
      })
    }
  }
  
  return(
  
      <div id="hero-section" className="max-h-full">
          <div className="py-[10.5rem] relative bg-center" style={{backgroundImage: "url('/hero-img.png')"}}>

            <div className="max-w-7xl mx-auto flex flex-col md:flex-row items-center gap-8 px-6 mr-10">
                <div className="flex-1">
                  <h1 className="text-4xl font-bold text-gray-800">Desbrave o ínfimo</h1>
                  <p className="text-gray-600 mt-4">O melhor de tecnologia e conforto para seus pés . . . </p>
                </div>
            </div>
            <button
              onClick={handleScrollBottom}
              className="cursor-pointer ml-72 mt-6 px-6 py-2 bg-red-500 text-white rounded hover:bg-red-600 transition">
              Shop Now
            </button>
        </div>

      </div>
  )
}