import React, { useState, useEffect } from 'react';
import { FaUserCircle, FaEnvelope, FaEdit, FaPlusCircle, FaBoxOpen, FaInfoCircle } from 'react-icons/fa';
import { ProductFormModal } from '../components/ProductFormModal';
import { PageWithNavLayout } from '../layouts/PageWithNav';

export function UserPerfil() {
  const [activeTab, setActiveTab] = useState('profile'); 
  const [showNewProductModal, setShowNewProductModal] = useState(false);

  const [user, setUser] = useState({
    name: 'João Silva',
    email: 'joao.silva@example.com',
    profilePicture: 'https://via.placeholder.com/150',
    bio: 'Entusiasta de tecnologia e amante de café. Sempre aprendendo e explorando novas ferramentas.'
  });

  const [products, setProducts] = useState([]);
  const [loadingProducts, setLoadingProducts] = useState(true);
  const [errorProducts, setErrorProducts] = useState(null);

  useEffect(() => {
    if (activeTab === 'products' && products.length === 0 && !errorProducts) {
      const dummyProducts = [
        { id: 1, name: 'Tênis PrimeRunner X', price: 350.00, imageUrl: 'https://via.placeholder.com/100x100?text=Tenis1' },
        { id: 2, name: 'Bota Caminhada Ultra', price: 520.00, imageUrl: 'https://via.placeholder.com/100x100?text=Bota1' },
        { id: 3, name: 'Chinelo Slide Confort', price: 80.00, imageUrl: 'https://via.placeholder.com/100x100?text=Chinelo1' },
      ];

      setTimeout(() => {
        setProducts(dummyProducts);
        setLoadingProducts(false);
      }, 1000);
    }
  }, [activeTab, products.length, errorProducts]);

  const handleEditProfile = () => {
    alert('Funcionalidade de edição de perfil será implementada aqui!');
  };

  const handleCadastrarProduto = () => {
    setShowNewProductModal(true);
  };

  const handleCloseModal = () => {
    setShowNewProductModal(false);
  };

  const handleProductAdded = (newProduct) => {
    setProducts((prevProducts) => [...prevProducts, newProduct]);
    setActiveTab('products'); 
  };

  return (

    <PageWithNavLayout hideSearchBar = {true} hideCategoryMenu = {true}>
      <div className="min-h-screen flex items-center justify-center bg-gray-100 p-4">
        <div className="bg-white rounded-lg shadow-xl w-full max-w-4xl flex flex-col md:flex-row">
          
          <div className="md:w-1/4 w-full p-6 bg-gray-50 border-r border-gray-200 rounded-l-lg md:rounded-tr-none rounded-t-lg md:rounded-tl-lg">
            <h3 className="text-xl font-bold text-gray-800 mb-6 border-b pb-3">Navegação</h3>
            <ul className="space-y-4">
              <li>
                <button
                  onClick={() => setActiveTab('profile')}
                  className={`w-full text-left py-3 px-4 rounded-lg flex items-center transition duration-200 ease-in-out 
                              ${activeTab === 'profile' ? 'bg-blue-600 text-white shadow-md' : 'text-gray-700 hover:bg-blue-100 hover:text-blue-700'}`}
                >
                  <FaUserCircle className="mr-3 text-lg" />
                  Meu Perfil
                </button>
              </li>
              <li>
                <button
                  onClick={() => setActiveTab('products')}
                  className={`w-full text-left py-3 px-4 rounded-lg flex items-center transition duration-200 ease-in-out 
                              ${activeTab === 'products' ? 'bg-blue-600 text-white shadow-md' : 'text-gray-700 hover:bg-blue-100 hover:text-blue-700'}`}
                >
                  <FaBoxOpen className="mr-3 text-lg" />
                  Meus Produtos
                </button>
              </li>
              
              <li>
                  <button
                      onClick={handleCadastrarProduto}
                      className="w-full text-left py-3 px-4 rounded-lg flex items-center transition duration-200 ease-in-out bg-green-500 hover:bg-green-600 text-white mt-4 shadow-md"
                  >
                      <FaPlusCircle className="mr-3 text-lg" />
                      Novo Produto
                  </button>
              </li>
            </ul>
          </div>

          <div className="md:w-3/4 w-full p-8">
            {activeTab === 'profile' && (
              <div className="animate-fadeIn">
                <h2 className="text-3xl font-bold text-center mb-8 text-gray-800">Detalhes do Perfil</h2>

                <div className="flex flex-col items-center mb-6">
                  <div className="relative w-32 h-32 rounded-full overflow-hidden border-4 border-blue-400 shadow-lg">
                    <img
                      src={user.profilePicture}
                      alt="Foto de Perfil"
                      className="w-full h-full object-cover"
                    />
                  </div>
                  <h3 className="text-2xl font-semibold mt-4 text-gray-900">{user.name}</h3>
                  <p className="text-gray-600 flex items-center mt-1">
                    <FaEnvelope className="mr-2 text-gray-500" /> {user.email}
                  </p>
                </div>

                <div className="mb-6 text-center">
                  <p className="text-gray-700 text-md leading-relaxed">
                    {user.bio}
                  </p>
                </div>

                <div className="flex justify-center">
                  <button
                    onClick={handleEditProfile}
                    className="bg-blue-600 hover:bg-blue-700 text-white font-bold py-2 px-6 rounded-full inline-flex items-center shadow-lg transform transition duration-200 hover:scale-105"
                  >
                    <FaEdit className="mr-2" />
                    Editar Perfil
                  </button>
                </div>
              </div>
            )}

            {activeTab === 'products' && (
              <div className="animate-fadeIn">
                <h2 className="text-3xl font-bold text-center mb-8 text-gray-800 flex items-center justify-center">
                  <FaBoxOpen className="mr-3 text-gray-600" /> Meus Produtos à Venda
                </h2>

                {loadingProducts ? (
                  <p className="text-center text-gray-500">Carregando produtos...</p>
                ) : errorProducts ? (
                  <p className="text-center text-red-500">Erro ao carregar produtos: {errorProducts.message}</p>
                ) : products.length === 0 ? (
                  <p className="text-center text-gray-500">Você ainda não tem produtos à venda.</p>
                ) : (
                  <div className="grid grid-cols-1 gap-4">
                    {products.map((product) => (
                      <div key={product.id} className="flex items-center p-4 border rounded-lg shadow-sm bg-gray-50 hover:bg-gray-100 transition duration-150 ease-in-out">
                        <img
                          src={product.imageUrl}
                          alt={product.name}
                          className="w-16 h-16 object-cover rounded-md mr-4 border"
                        />
                        <div className="flex-grow">
                          <h4 className="text-lg font-semibold text-gray-800">{product.name}</h4>
                          <p className="text-gray-600 text-sm">R$ {product.price.toFixed(2)}</p>
                        </div>
                        <button
                          onClick={() => alert(`Editar produto: ${product.name}`)}
                          className="ml-4 p-2 bg-yellow-500 hover:bg-yellow-600 text-white rounded-full flex items-center justify-center text-sm transform transition duration-150 hover:scale-110"
                          title="Editar Produto"
                        >
                          <FaEdit />
                        </button>
                      </div>
                    ))}
                  </div>
                )}
              </div>
            )}
          </div>
        </div>

        {showNewProductModal && (
          <ProductFormModal 
            onClose={handleCloseModal} 
            onProductAdded={handleProductAdded} 
          />
        )}
      </div>
    </PageWithNavLayout>
  );
}