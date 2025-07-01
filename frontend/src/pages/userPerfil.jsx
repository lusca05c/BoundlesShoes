  import React from 'react';
  import { FaUserCircle, FaEnvelope, FaEdit } from 'react-icons/fa'; // Importing user, envelope, and edit icons

  export function UserPerfil() {
    // Dummy user data for demonstration
    const user = {
      name: 'João Silva',
      email: 'joao.silva@example.com',
      profilePicture: 'https://via.placeholder.com/150', // Replace with a real image URL or upload functionality
      bio: 'Entusiasta de tecnologia e amante de café. Sempre aprendendo e explorando novas ferramentas.'
    };

    const handleEditProfile = () => {
      alert('Funcionalidade de edição de perfil será implementada aqui!');
      // In a real application, you would navigate to an edit form or open a modal
    };

    return (
      <div className="min-h-screen flex items-center justify-center bg-gray-100 p-4">
        <div className="bg-white p-8 rounded-lg shadow-xl w-full max-w-md">
          <h2 className="text-3xl font-bold text-center mb-8 text-gray-800">Meu Perfil</h2>

          <div className="flex flex-col items-center mb-6">
            <div className="relative w-32 h-32 rounded-full overflow-hidden border-4 border-blue-400 shadow-lg">
              <img
                src={user.profilePicture}
                alt="Foto de Perfil"
                className="w-full h-full object-cover"
              />
              {/* You could add an overlay for changing profile picture here */}
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

          {/* You could add more sections here, e.g., "Minhas Atividades", "Configurações" */}
        </div>
      </div>
    );
  }