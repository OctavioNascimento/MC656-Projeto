import { useEffect, useState } from 'react';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import L from 'leaflet';

// Corrigir ícones padrão do Leaflet
delete L.Icon.Default.prototype._getIconUrl;
L.Icon.Default.mergeOptions({
  iconRetinaUrl: 'https://unpkg.com/leaflet@1.7.1/dist/images/marker-icon-2x.png',
  iconUrl: 'https://unpkg.com/leaflet@1.7.1/dist/images/marker-icon.png',
  shadowUrl: 'https://unpkg.com/leaflet@1.7.1/dist/images/marker-shadow.png',
});

const userIcon = L.icon({
  iconUrl: '/icons/user-icon.png',
  iconSize: [32, 32],
  iconAnchor: [16, 32],
  popupAnchor: [0, -32],
});

const bikeIcon = L.icon({
  iconUrl: '/icons/bike-icon.png',
  iconSize: [32, 20],
  iconAnchor: [16, 32],
  popupAnchor: [0, -32],
});

export default function Mapa({ width, height }) {
  const [userLocation, setUserLocation] = useState(null);
  const [bikeLocations, setBikeLocations] = useState([]);

//   useEffect(() => {
//     navigator.geolocation.getCurrentPosition(
//         (pos) => {
//         const { latitude, longitude } = pos.coords;
//         setUserLocation({ lat: latitude, lng: longitude });

//         // Dados simulados de bikes
//         setBikeLocations([
//             { lat: latitude + 0.001, lng: longitude + 0.001 },
//             { lat: latitude - 0.001, lng: longitude + 0.002 },
//         ]);
//         },
//         (err) => {
//         console.error('Erro ao obter localização:', err);
//         alert('Não foi possível obter sua localização. Verifique as permissões.');
//         }
//     );
//     }, []);

    useEffect(() => {
    const latitude = -22.8140016;
    const longitude = -47.0688476;
    setUserLocation({ lat: latitude, lng: longitude });
    setBikeLocations([
        { lat: latitude + 0.001, lng: longitude + 0.001 },
        { lat: latitude - 0.001, lng: longitude + 0.002 },
        { lat: latitude - 0.002, lng: longitude - 0.002 },
        { lat: latitude - 0.001, lng: longitude + 0.003 },
    ]);
    }, []);


  if (!userLocation) return <p>Carregando mapa...</p>;

  return (
    <MapContainer center={userLocation} zoom={16} style={{ height: height, width: width }}>
      <TileLayer
        attribution='&copy; <a href="https://carto.com/">CARTO</a>'
        url='https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}{r}.png'
      />

      <Marker position={userLocation} icon={userIcon}>
        <Popup>Você está aqui</Popup>
      </Marker>

      {bikeLocations.map((bike, index) => (
        <Marker key={index} position={bike} icon={bikeIcon}>
          <Popup>Bicicleta disponível</Popup>
        </Marker>
      ))}
    </MapContainer>
  );
}
