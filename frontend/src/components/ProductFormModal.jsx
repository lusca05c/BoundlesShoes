import React, { useState } from 'react';
import { FaTimes, FaPlus, FaUpload } from 'react-icons/fa';

export function ProductFormModal({ onClose, onProductAdded }) {
  const [productName, setProductName] = useState('');
  const [productPrice, setProductPrice] = useState('');
  const [productDescription, setProductDescription] = useState('');
  const [productImage, setProductImage] = useState(null);
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState('');

  const handleFileChange = (event) => {
    setProductImage(event.target.files[0]);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    if (!productName || !productPrice || !productImage) {
      setMessage('Por favor, preencha todos os campos obrigatórios (Nome, Preço, Imagem).');
      return;
    }

    setLoading(true);
    setMessage('Cadastrando produto...');

    const formData = new FormData();
    formData.append('name', productName);
    formData.append('price', parseFloat(productPrice));
    formData.append('description', productDescription);
    formData.append('file', productImage);

    try {
      const response = await fetch('http://localhost:8080/api/products', {
        method: 'POST',
        body: formData,
      });

      if (response.ok) {
        const newProduct = await response.json();
        setMessage('Produto cadastrado com sucesso!');
        if (onProductAdded) {
          onProductAdded(newProduct);
        }
        setTimeout(() => {
          setProductName('');
          setProductPrice('');
          setProductDescription('');
          setProductImage(null);
          onClose();
        }, 1500);
      } else {
        const errorData = await response.json();
        setMessage(`Erro ao cadastrar produto: ${errorData.message || response.statusText}`);
      }
    } catch (error) {
      setMessage(`Erro de conexão: ${error.message}`);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="fixed inset-0 bg-gray-600 bg-opacity-50 flex items-center justify-center z-50 animate-fadeIn">
      <div className="bg-white p-8 rounded-lg shadow-xl max-w-md w-full relative">
        <button
          onClick={onClose}
          className="absolute top-4 right-4 text-gray-500 hover:text-gray-800 transition-colors"
        >
          <FaTimes size={24} />
        </button>

        <h2 className="text-2xl font-bold text-center mb-6 text-gray-800">Cadastrar Novo Produto</h2>

        <form onSubmit={handleSubmit} className="space-y-4">
          <div>
            <label htmlFor="productName" className="block text-gray-700 text-sm font-bold mb-2">
              Nome do Produto:
            </label>
            <input
              type="text"
              id="productName"
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              value={productName}
              onChange={(e) => setProductName(e.target.value)}
              required
            />
          </div>

          <div>
            <label htmlFor="productPrice" className="block text-gray-700 text-sm font-bold mb-2">
              Preço:
            </label>
            <input
              type="number"
              id="productPrice"
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              value={productPrice}
              onChange={(e) => setProductPrice(e.target.value)}
              step="0.01"
              required
            />
          </div>

          <div>
            <label htmlFor="productDescription" className="block text-gray-700 text-sm font-bold mb-2">
              Descrição:
            </label>
            <textarea
              id="productDescription"
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline h-24 resize-none"
              value={productDescription}
              onChange={(e) => setProductDescription(e.target.value)}
            />
          </div>

          <div>
            <label htmlFor="productImage" className="block text-gray-700 text-sm font-bold mb-2">
              Imagem do Produto:
            </label>
            <input
              type="file"
              id="productImage"
              accept="image/*"
              onChange={handleFileChange}
              className="block w-full text-sm text-gray-500 file:mr-4 file:py-2 file:px-4 file:rounded-full file:border-0 file:text-sm file:font-semibold file:bg-blue-50 file:text-blue-700 hover:file:bg-blue-100"
              required
            />
            {productImage && (
              <p className="text-gray-600 text-xs mt-1">Arquivo selecionado: {productImage.name}</p>
            )}
          </div>

          {message && (
            <p className={`text-center text-sm ${message.includes('Erro') ? 'text-red-500' : 'text-green-600'}`}>
              {message}
            </p>
          )}

          <button
            type="submit"
            className="w-full bg-green-600 hover:bg-green-700 text-white font-bold py-2 px-4 rounded-full inline-flex items-center justify-center shadow-lg transition duration-200 focus:outline-none focus:shadow-outline disabled:opacity-50 disabled:cursor-not-allowed"
            disabled={loading}
          >
            {loading ? (
              'Cadastrando...'
            ) : (
              <>
                <FaPlus className="mr-2" />
                Cadastrar
              </>
            )}
          </button>
        </form>
      </div>
    </div>
  );
}