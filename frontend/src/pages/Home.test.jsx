import { render, screen } from '@testing-library/react'
import Home from './Home'

test('Should render a input with a placeholder "Procura"', () => {
  render(<Home />)
  expect(screen.getByPlaceholderText('Procura')).toBeInTheDocument();
})