import { render, screen } from '@testing-library/react'
import Home from './Home'
import { MemoryRouter } from 'react-router-dom';

test('Should render a input with a placeholder "Procura"', () => {
  render(
    <MemoryRouter>
      <Home />
    </MemoryRouter>
  )
  expect(screen.getByPlaceholderText('Procura')).toBeInTheDocument();
})